package service;

import domain.Movie;
import domain.Rating;
import domain.Review;
import domain.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.NoArgsConstructor;
import repository.MovieRepository;
import repository.ReviewRepository;
import repository.UserRepository;
import util.JpaUtil;
import java.util.Date;
import java.util.List;

//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class OrderService {
//    /* 의존 관계 추가 */
//    private final OrderRepository orderRepository;
//    private final MemberRepository memberRepository;
//    private final ItemRepository itemRepository;
//
//    /**
//     * 주문
//     */
//    @Transactional
//    public Long order(Long memberId, Long itemId, int count) {
//        // 엔티티 조회
//        Member member = memberRepository.findOne(memberId);
//        Item item = itemRepository.findOne(itemId);
//
//        // 배송 정보 생성
//        Delivery delivery = new Delivery();
//        delivery.setAddress(member.getAddress());
//        delivery.setDeliveryStatus(DeliveryStatus.READY);
//
//        // 주문 상품 생성
//        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
////        OrderItem orderItem1 = new OrderItem(); // NoArgsConstructor 로 인해 protected 생성자이므로 사용하지 못함
//
//        // 주문 생성
//        Order order = Order.createOrder(member, delivery, orderItem);
//
//        // 주문 저장
//        orderRepository.save(order); // 하나만 저장해 줘도 orderitem이랑 delivery가 persist 된다
//        /*
//         * cascade 사용 ??
//         * 참조하는 것이 private owner? 인 경우에서 사용
//         * 다른 값이 참조할 수 없는 경우 사용
//         */
//        return order.getId();
//    }
//
//    /**
//     * 주문 취소
//     *
//     * @param orderId order id
//     */
//    @Transactional
//    public void cancelOrder(Long orderId) {
//        // 주문 엔티티 조회
//        Order order = orderRepository.findOne(orderId);
//        // 주문 취소
//        order.cancel();
//    }
//
//    // 검색
//    public List<Order> findOrder(OrderSearch orderSearch){
//        return orderRepository.findAll(orderSearch);
//    }
//
//}


@NoArgsConstructor
public class ReviewService {

    private static MovieRepository movieRepository;
    private static ReviewRepository reviewRepository;
    private static UserRepository userRepository;

    private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

    public static boolean insertReview(String content, Rating rating) {
        boolean result = true;

        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        //Movie movie = movieRepository.findOne(movieId);
        //User user = userRepository.findOne(userId);


        //일단 직접 생성
        Movie movie = Movie.builder()
                .movieId("1")
                .movieTitle("기생충")
                .movieDirector("봉준호")
                .moviePoster("https://img.movist.com/?img=/x00/05/04/96_p1.jpg")
                .movieType("스릴러")
                .movieReleaseDate(new Date()) //양방향은 어떻게 함? (reivewList)
                .build();

        em.persist(movie);

        User user = User.builder()
                .userId(1)
                .userAccountId("coocoa389")
                .userPasswd("1234")
                .userName("김지혜")
                .userBirthday(new Date())
                .build();//양방향 우짬? (reivewList, likeList)

        em.persist(user);
        try {
            Review review = Review.builder()
                    .reviewId(1)
                    .movie(movie)
                    .user(user)
                    .reviewContent(content)
                    .rating(Rating.builder().ratingId(1).ratingScore(5).build())
                    .reviewDate(new Date())
                    .build();

            reviewRepository.save(review);
            tx.commit();
        }catch (Exception e){
            result = false;
            tx.rollback();
        }finally {
            em.close();
        }
        return result;

    }

    public static Review geReview(int movieId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        User user = null;
        Review review = null;
        tx.begin();
        try {
            // Movie movie = movieRepository.findOne(movieId);
//            String getMovieJPQL = "SELECT m from Movie m WHERE movie_id=:movieId";
//            Movie movie = em.createQuery(getMovieJPQL, Movie.class)
//                    .setParameter("movieId",movieId)
//                    .getSingleResult();
            //아닌가? movieId만 있으면 굳이 movie 객체를 안 만들어도 되지?

            String getReviewJPQL = "SELECT r from Review r WHERE movie_id=:movieId";
//            Movie movie = em.createQuery(getMovieJPQL, Movie.class)
//                    .setParameter("movieId",movieId)
//                    .getSingleResult();


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return review;
    }

}
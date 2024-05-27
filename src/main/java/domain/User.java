package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"reviewList"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId; //유저Id

    @Column(name = "user_account_id",unique = true)
    private String userAccountId; //유저 계정

    @Column(name = "user_password")
    private String userPassword; //유저 패스워드

    @Column(name = "user_name")
    private String userName; //유저 이름

    @Temporal(TemporalType.DATE)
    @Column(name = "user_birthday")
    private Date userBirthday; //유저 생일

    @Column(name = "user_type")
    private boolean userType; //유저 타입(관리자 1 일반인 0)

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList = new ArrayList<>(); //유저에 매핑된 리뷰 리스트
}

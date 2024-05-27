CREATE TABLE Review (
  review_id int(10) NOT NULL AUTO_INCREMENT,
  review_content varchar(1000) DEFAULT NULL,
  review_date date DEFAULT NULL,
  user_id int(10) NOT NULL,
  movie_id int(10) NOT NULL,
  PRIMARY KEY (review_id)
) ENGINE=InnoDB;

CREATE TABLE User (
  user_id int(10) NOT NULL AUTO_INCREMENT,
  user_account_id varchar(20) NOT NULL,
  user_passwd varchar(20) DEFAULT NULL,
  user_name varchar(10) NOT NULL,
  user_birthday date DEFAULT NULL,
  user_type tinyint(1) DEFAULT 0 COMMENT '관리자 여부',
  PRIMARY KEY (user_id)
) ENGINE=InnoDB;

CREATE TABLE Movie (
  movie_id int(10) NOT NULL AUTO_INCREMENT,
  movie_title varchar(100) DEFAULT NULL,
  movie_director varchar(20) DEFAULT NULL,
  movie_poster varchar(2000) DEFAULT NULL,
  movie_type varchar(20) DEFAULT NULL,
  movie_release_date date DEFAULT NULL,
  PRIMARY KEY (movie_id)
) ENGINE=InnoDB;

CREATE TABLE Rating (
  rating_id int(10) NOT NULL AUTO_INCREMENT,
  rating_score int(10) DEFAULT NULL,
  review_id int(10) NOT NULL,
  PRIMARY KEY (rating_id),
  KEY fk_review_id (review_id),
  CONSTRAINT fk_review_id FOREIGN KEY (review_id) REFERENCES Review (review_id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE Likes (
  likes_id int(10) NOT NULL AUTO_INCREMENT,
  likes_statement tinyint(1) DEFAULT NULL,
  user_id int(10) NOT NULL,
  review_id int(10) NOT NULL,
  PRIMARY KEY (likes_id),
  KEY fk_user_id (user_id),
  KEY fk_like_review_id (review_id),
  CONSTRAINT fk_like_review_id FOREIGN KEY (review_id) REFERENCES Review (review_id) ON DELETE CASCADE,
  CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES User (user_id) ON DELETE CASCADE
) ENGINE=InnoDB;

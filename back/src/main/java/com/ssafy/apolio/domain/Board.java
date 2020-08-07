package com.ssafy.apolio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ssafy.apolio.domain.account.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Heart> hearts = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TagArticle> tagArticles = new ArrayList<>();

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    private String title;

    private String content;

    private String img_thumb;

    private LocalDateTime create_date;

    //==연관관계 메서드==//
    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setBoard(this);
    }

    public void addHeart(Heart heart) {
        hearts.add(heart);
        heart.setBoard(this);
    }

    public void addTagArticle(TagArticle tagArticle) {
        tagArticles.add(tagArticle);
        tagArticle.setBoard(this);
    }

    //==생성 메서드==//
    public static Board createBoard(User user, String title, String content, String img_thumb, TagArticle... tagArticles) {
        Board board = new Board();

        board.setTitle(title);
        board.setContent(content);
        board.setImg_thumb(img_thumb);
        board.setCreate_date(LocalDateTime.now());
        board.setUser(user);
        for (TagArticle tagArticle : tagArticles){
            board.addTagArticle(tagArticle);
        }

        return board;
    }

}
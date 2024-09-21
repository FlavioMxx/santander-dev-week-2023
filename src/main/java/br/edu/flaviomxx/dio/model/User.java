package br.edu.flaviomxx.dio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL) //Quando usuário for deletado, conta irá junto
    private Account account;

    @OneToOne(cascade = CascadeType.ALL) //Quando usuário for deletado, cartão irá junto
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //Quando usuário for deletado, features irão junto
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //Quando usuário for deletado, news irão junto
    private List<News> news;
}

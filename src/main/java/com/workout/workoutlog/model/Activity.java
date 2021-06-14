package com.workout.workoutlog.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TB_ACTIVITY")
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Setter
    @NonNull
    private String name;
}

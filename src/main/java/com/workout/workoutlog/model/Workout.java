package com.workout.workoutlog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_WORKOUT")
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "ACTIVITY", nullable = false)
    @NonNull
    private Activity activity;

    @Column(nullable = false)
    @NonNull
    private Date date;

    @Column(nullable = false)
    @NonNull
    private float spentTime;
}

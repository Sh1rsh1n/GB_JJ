package github.sh1rsh1n.task2.models;


import github.sh1rsh1n.task2.Column;

import java.util.UUID;

@github.sh1rsh1n.task2.Entity
public class Entity {

    @Column(name = "id", primaryKey = true)
    private UUID id;

}

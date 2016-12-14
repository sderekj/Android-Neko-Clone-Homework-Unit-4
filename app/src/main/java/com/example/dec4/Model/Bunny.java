package com.example.dec4.Model;

import java.util.Calendar;

import nl.qbusict.cupboard.annotation.Column;

/**
 * Created by Millochka on 12/4/16.
 */

public class Bunny {


        // a POJO for cupboard must always contain a variable of type Long called _id.
        // this will serve as the index for the POJO within the SQLite table and will
        // auto-increment.
        //private Long _id;

        private String name;

        // column name defaults to field name
        // or we can use @Column annotation to specify a custom name
        @Column("last_fed")
        private Long lastFed;

    @Column("bynny_icon")
    private int bunnyIcon;



        // required zero argument constructor
        public Bunny() {
            this.name = "Unknown";
            this.lastFed = Calendar.getInstance().getTimeInMillis();
            this.bunnyIcon=0;


        }

        public Bunny(String name, Long lastFed, int bunnyIcon) {
            this.name = name;
            this.lastFed = lastFed;
            this.bunnyIcon=bunnyIcon;

        }

//        public Long getId() {
//            return _id;
//        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getLastFed() {
            return lastFed;
        }

        public void setLastFed(Long lastFed) {
            this.lastFed = lastFed;
        }

    public int getBunnyIcon() {
        return bunnyIcon;
    }
}



package com.example.daggerdemo;

import java.util.List;

class MovieBean {
    List<Subjects> subjects;

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public  class Subjects {
        String title;

        public String getTitle() {
            return title;
        }
    }
}

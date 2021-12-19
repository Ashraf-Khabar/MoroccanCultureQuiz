package com.example.myquizapp;

public class questions {
     private int id ;
     private String question ;
     private int image ;
     private String option1 ;
     private String option2 ;
     private String option3 ;
     private String option4 ;
     private int correctAnswer ;

     public questions(int id, String question, int image, String option1, String option2, String option3, String option4, int correctAnswer) {
          this.id = id;
          this.question = question;
          this.image = image;
          this.option1 = option1;
          this.option2 = option2;
          this.option3 = option3;
          this.option4 = option4;
          this.correctAnswer = correctAnswer;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getQuestion() {
          return question;
     }

     public void setQuestion(String question) {
          this.question = question;
     }

     public int getImage() {
          return image;
     }

     public void setImage(int image) {
          this.image = image;
     }

     public String getOption1() {
          return option1;
     }

     public void setOption1(String option1) {
          this.option1 = option1;
     }

     public String getOption2() {
          return option2;
     }

     public void setOption2(String option2) {
          this.option2 = option2;
     }

     public String getOption3() {
          return option3;
     }

     public void setOption3(String option3) {
          this.option3 = option3;
     }

     public String getOption4() {
          return option4;
     }

     public void setOption4(String option4) {
          this.option4 = option4;
     }

     public int getCorrectAnswer() {
          return correctAnswer;
     }

     public void setCorrectAnswer(int correctAnswer) {
          this.correctAnswer = correctAnswer;
     }

     @Override
     public String toString() {
          return "questions{" +
                  "id=" + id +
                  ", question='" + question + '\'' +
                  ", image=" + image +
                  ", option1='" + option1 + '\'' +
                  ", option2='" + option2 + '\'' +
                  ", option3='" + option3 + '\'' +
                  ", option4='" + option4 + '\'' +
                  ", correctAnswer=" + correctAnswer +
                  '}';
     }
}

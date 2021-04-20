package net.codejava;

 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "questions")
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String option1;
    private String option2;
    private Long votes1;
    private Long votes2;
    
    protected Question() {
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
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
    
    public Long getVotes1() {
        return votes1;
    }
    public void setVotes1(Long votes1) {
        this.votes1 = votes1;
    }
    public Long getVotes2() {
        return votes2;
    }
    public void setVotes2(Long votes2) {
        this.votes2 = votes2;
    }
}
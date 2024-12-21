package dev.handsonproject.movies.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {
    
    @Id
    private ObjectId id;
    private String imdbId;
    private String review; 

    public Reviews(String review,String imdbId){
        this.review = review;
        this.imdbId = imdbId;
    }
}

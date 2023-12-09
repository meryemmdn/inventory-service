package max.xproce.inventoryservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long id;
    private  String name;
    private  String url;
    private  String description;
    private Date datePublication;
    @ManyToOne
    private Creator creator;
}

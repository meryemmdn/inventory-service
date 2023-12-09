package max.xproce.inventoryservice.web;

import max.xproce.inventoryservice.Repository.CreatorRepository;
import max.xproce.inventoryservice.Repository.VideoRepository;
import max.xproce.inventoryservice.entities.Creator;
import max.xproce.inventoryservice.entities.Video;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


import java.util.List;

@Controller
public class VideoGraphQlController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;
    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository){
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }
    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll();
    }
    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }
    @MutationMapping
    public Creator saveCreator(@Argument Creator creator){
        Creator creators =  modelMapper.map(creator, Creator.class);
        return creatorRepository.save(creator) ;
    }
    @MutationMapping
    public Video saveVideo(@Argument Video video){
        Video video1=modelMapper.map(video,Creator.class);
        return videoRepository.save(video) ;
    }
}

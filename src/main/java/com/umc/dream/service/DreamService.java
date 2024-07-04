package com.umc.dream.service;

import com.umc.dream.apiPayload.code.status.ErrorStatus;
import com.umc.dream.apiPayload.exception.GeneralException;
import com.umc.dream.converter.*;
import com.umc.dream.domain.*;
import com.umc.dream.dto.DreamRequestDto;
import com.umc.dream.dto.FollowRequestDto;
import com.umc.dream.dto.GetDreamResponseDto;
import com.umc.dream.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DreamService {
    private final DreamRepository dreamRepository;
    private final UserRepository userRepository;
    private final PeopleRepository peopleRepository;
    private final PlaceRepository placeRepository;
    private final HashtagRepository hashtagRepository;
    private final FeelingRepository feelingRepository;

    @Transactional
    public Dream createDream(DreamRequestDto dreamRequestDto) {
        User user = userRepository.findById(dreamRequestDto.getUsers_id())
                .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));
        Dream dream = DreamConverter.toDream(dreamRequestDto, user);
        dreamRepository.save(dream);

        List<People> peopleList = new ArrayList<>();
        for (String s : dreamRequestDto.getPeople()) {
            People people = PeopleConverter.toPeople(s, dream);
            peopleList.add(people);
        }
        peopleRepository.saveAll(peopleList);

        List<Hashtag> hashtagList = new ArrayList<>();
        for (String s : dreamRequestDto.getHashtag()) {
            Hashtag hashtag = HashtagConverter.toHashtag(s, dream);
            hashtagList.add(hashtag);
        }
        hashtagRepository.saveAll(hashtagList);

        List<Feeling> feelings = new ArrayList<>();
        for (String s : dreamRequestDto.getFeeling()) {
            Feeling feeling = FeelingConverter.toFeeling(s, dream);
            feelings.add(feeling);
        }
        feelingRepository.saveAll(feelings);

        List<Place> placeList = new ArrayList<>();
        for (String s : dreamRequestDto.getPlace()) {
            Place place = PlaceConverter.toPlace(s, dream);
            placeList.add(place);
        }
        placeRepository.saveAll(placeList);

        return dream;
    }

    @Transactional
    public List<GetDreamResponseDto> getDream(Long user_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new GeneralException(ErrorStatus._BAD_REQUEST));
        List<Dream> dreams = dreamRepository.findAllByUser(user);
        List<GetDreamResponseDto> getDreamResponseDtos = new ArrayList<>();
        for (Dream d : dreams) {
            People people = peopleRepository.findFirstByDream(d);
            Place place = placeRepository.findFirstByDream(d);
            Feeling feeling = feelingRepository.findFirstByDream(d);
            Hashtag hashtag = hashtagRepository.findFirstByDream(d);
            getDreamResponseDtos.add(DreamConverter.toGetDreamResponse(d, people, place, feeling, hashtag));
        }
        return getDreamResponseDtos;
    }
}

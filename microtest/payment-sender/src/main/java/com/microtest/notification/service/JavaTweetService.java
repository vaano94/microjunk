package com.microtest.notification.service;

import com.microtest.notification.domain.Tweet;
import com.microtest.notification.repository.TweetRepository;
import com.microtest.notification.util.Twitter4jClientUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import twitter4j.Status;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JavaTweetService {

    private TweetRepository tweetRepository;

    private Twitter4jClientUtil twitter4JClientUtil;

    private ModelMapper modelMapper;

    @Autowired
    private ClientCredentialsResourceDetails clientCredentialsResourceDetails;
    @Autowired
    public OAuth2RestTemplate clientCredentialsRestTemplate;

    @Autowired
    public JavaTweetService(TweetRepository tweetRepository, Twitter4jClientUtil twitter4JClientUtil, ModelMapper modelMapper) {
        this.tweetRepository = tweetRepository;
        this.twitter4JClientUtil = twitter4JClientUtil;
        this.modelMapper = modelMapper;
    }

    @Scheduled(fixedDelay = 8000)
    public void obtainAndSaveNewTweets() {
        if (twitter4JClientUtil == null) {
            return;
        }
        HashMap<String, Status> tweets = twitter4JClientUtil.getRecentTweets();
        List<Tweet> tweetStream = tweets.values()
                .stream()
                .map(tweet -> modelMapper.map(tweet, Tweet.class))
                .collect(Collectors.toList());
        tweetRepository.save(tweetStream);
    }



}

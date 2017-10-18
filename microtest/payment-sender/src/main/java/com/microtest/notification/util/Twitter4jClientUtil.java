package com.microtest.notification.util;

import org.apache.commons.configuration.ConfigurationFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.*;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
//@Scope(value = SCOPE_PROTOTYPE)
public class Twitter4jClientUtil {

    private static Twitter twitter;

    @PostConstruct
    public void init() {
        Configuration configuration = ConfigurationContext.getInstance();
        OAuthAuthorization authAuthorization = new OAuthAuthorization(configuration);
        twitter = new TwitterFactory().getInstance(authAuthorization);
    }

    private Query createSearchQuery(String tag, Integer count) {
        Query query = new Query();
        query.setQuery(tag);
        query.setCount(count);
        query.setResultType(Query.RECENT);
        return query;
    }


    public HashMap<String, Status> getRecentTweets() {
        HashMap<String, Status> uniqueTweetMap = new HashMap<>();
        try {
            QueryResult microserviceSearch = twitter.search(createSearchQuery("#microservice", 30));
            QueryResult javaSearch = twitter.search(createSearchQuery("#java", 30));

            List<Status> hashtagTweets = microserviceSearch.getTweets();
            for (Status tweet : hashtagTweets) {
                uniqueTweetMap.put(tweet.getText(), tweet);
            }
            List<Status> javaTweets = javaSearch.getTweets();
            for (Status tweet : javaTweets) {
                uniqueTweetMap.put(tweet.getText(), tweet);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return uniqueTweetMap;
    }

    public static void main(String args[]) {
//        Twitter twitter = new TwitterFactory().getInstance();
//        // Twitter Consumer key & Consumer Secret
//        twitter.setOAuthConsumer("ssFLQ4MjgNreMPSUJdvg2IyDf", "Zaua4rTQgjDYKBtOIBzaHBgDG2fynxVyQbdvX0oIGqeg6lCIIw");
//        // Twitter Access token & Access token Secret
//        twitter.setOAuthAccessToken(new AccessToken("756784408758251520-dIa09vK9C1aW9qNhpe3xhloGGAUnqSN",
//                "OV6L6CgerRpxTpX9ZtwlHtBv0Hsl6rsUMB5kihFjGz2Tp"));
        try {
            // Getting Twitter Timeline using Twitter4j API
//            ResponseList statusReponseList = twitter.getUserTimeline(new Paging(1, 5));
//            for (Object status : statusReponseList) {
//                Status s = (Status)status;
//                System.out.println(s.getText());
//            }
//            // Post a Tweet using Twitter4j API
//            Status status = twitter.updateStatus("Hello");
//            System.out.println("Successfully updated the status to [" + status.getText() + "].");
            HashMap<String, Status> uniqueTweetMap = new HashMap<>();

            Query microserviceHashTagQuery = new Query();
            microserviceHashTagQuery.setQuery("#microservice");
            microserviceHashTagQuery.setCount(30);
            microserviceHashTagQuery.setResultType(Query.RECENT);
            QueryResult search = twitter.search(microserviceHashTagQuery);
            List<Status> hashtagTweets = search.getTweets();
            for (Status tweet : hashtagTweets) {
                uniqueTweetMap.put(tweet.getText(), tweet);
            }

            Query javaHashTagQuery = new Query();
            javaHashTagQuery.setQuery("#java");
            javaHashTagQuery.setCount(30);
            javaHashTagQuery.setResultType(Query.RECENT);
            search = twitter.search(javaHashTagQuery);
            List<Status> javaTweets = search.getTweets();

            for (Status tweet : javaTweets) {
                uniqueTweetMap.put(tweet.getText(), tweet);
            }

            for (Status status : uniqueTweetMap.values()) {
                System.out.println(status.getText());
            }


        } catch (Exception e) {

        }
    }
}
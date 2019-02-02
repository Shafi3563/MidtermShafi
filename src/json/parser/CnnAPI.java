package json.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import databases.ConnectToMongoDB;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CnnAPI {
    /*
      You can get API_KEY from this below link. Once you have the API_KEY, you can fetch the top-headlines news.
      https://newsapi.org/s/cnn-api
      my API Key : 7782f2d27fa4490091bf6741b4705b2f
      Fetch This following CNN API, It will return some news in Json data. Parse this data and construct
      https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=7782f2d27fa4490091bf6741b4705b2f
      After getting Json Format of the news, You can go to json validator link: https://jsonlint.com/ to see
      how it can be parsed.

      */
     /* {
	"status": "ok",
	"totalResults": 10,
	"articles": {
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": "Analysis by Chris Cillizza, CNN Editor-at-large",
		"title": "Donald Trump's spot-on compliment for Kamala Harris",
		"description": "In an interview Thursday with The New York Times, President Donald Trump was asked whether there was anyone in the rapidly forming 2020 Democratic field who he thought might be his toughest opponent.",
		"url": "http://us.cnn.com/2019/02/01/politics/donald-trump-kamala-harris-2020/index.html",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/190120201838-03-kamala-harris-lead-image-super-tease.jpg",
		"publishedAt": "2019-02-01T19:56:21Z",
		"content": "THE POINT -- NOW ON YOUTUBE! \r\nIn each episode of his weekly YouTube show, Chris Cillizza will delve a little deeper into the surreal world of politics. Click to subscribe!"
	}, {
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": "Barbara Starr, CNN Pentagon Correspondent",
		"title": "Pentagon warns ISIS likely to retake territory in Syria after US withdraws",
		"description": "The Pentagon believes ISIS could re-emerge and take back territory in Syria within months if the US does not maintain military pressure on the terror group, according to an official familiar with the latest assessment.",
		"url": "http://us.cnn.com/2019/02/01/politics/pentagon-syria-isis-warning/index.html",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/151127115607-isis-flag-super-tease.jpg",
		"publishedAt": "2019-02-01T19:45:14Z",
		"content": "(CNN)The Pentagon believes ISIS could re-emerge and take back territory in Syria within months if the US does not maintain military pressure on the terror group, according to an official familiar with the latest assessment.\r\nThe warning comes as the Pentagon … [+3215 chars]"
	}, {
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": "Gregory Krieg, CNN",
		"title": "Elizabeth Warren apologized to Cherokee Nation over DNA test, tribe says",
		"description": "Sen. Elizabeth Warren has apologized to Cherokee Nation leaders over her attempt to use a DNA test to confirm her past claims to Native American ancestry, the tribe said.",
		"url": "http://us.cnn.com/2019/02/01/politics/elizabeth-warren-apology-to-cherokee-nation/index.html",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/190110183344-elizabeth-warren-iowa-super-tease.jpg",
		"publishedAt": "2019-02-01T19:41:31Z",
		"content": "(CNN)Sen. Elizabeth Warren has apologized to Cherokee Nation leaders over her attempt to use a DNA test to confirm her past claims to Native American ancestry, the tribe said. \r\nThe presidential hopeful \"reached out to us and has apologized to the tribe,\" Che… [+3839 chars]"
	}, {
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": null,
		"title": "Conway: Booker often sounds like a Hallmark card - CNN Video",
		"description": "White House counselor Kellyanne Conway reacts to Sen. Cory Booker's (D-NJ) announcement to run for president in the 2020 election.",
		"url": "http://us.cnn.com/videos/politics/2019/02/01/kellyanne-conway-cory-booker-bts-vpx-crn.cnn",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/190201133955-kellyanne-conway-2-1-super-tease.jpg",
		"publishedAt": "2019-02-01T19:38:34.0795826Z",
		"content": "Chat with us in Facebook Messenger. Find out what's happening in the world as it unfolds."
	}, {
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": "Analysis by Nia-Malika Henderson, Senior Political Reporter",
		"title": "Obama's reluctance on race gives way to roars from Booker and Harris",
		"description": "Cory Booker and Kamala Harris kicked off their 2020 campaigns like no other black presidential candidates ever have, including the only one who has won. Perhaps that's a privilege only they have -- afforded only after eight years of the first black US preside…",
		"url": "http://us.cnn.com/2019/02/01/politics/cory-booker-kamala-harris-obama-race/index.html",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/190201123239-booker-obama-harris-split-super-tease.jpg",
		"publishedAt": "2019-02-01T18:13:31Z",
		"content": "CNN's Nia-Malika Henderson explores the politics of identity in American life -- race, religion, region, gender, class and party."
	}, {
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": null,
		"title": "Voting in the US and why it's so difficult - CNN Video",
		"description": "From voter registration to a tedious election process, CNN's Rachel Crane explains why voting in the United States is so difficult.",
		"url": "http://us.cnn.com/videos/politics/2018/10/30/voting-online-us-america-orig.cnn",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/181030163618-voting-online-us-america-orig-00000000-super-tease.jpg",
		"publishedAt": "2019-02-01T17:08:46.2690231Z",
		"content": "Chat with us in Facebook Messenger. Find out what's happening in the world as it unfolds."
	}, {
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": "Analysis by Zachary B. Wolf, CNN",
		"title": "Here's why Republicans don't want an Election Day holiday",
		"description": "Mitch McConnell, the Senate majority leader, dismissed a House proposal for sweeping election reform by attacking the specific proposal in a much larger bill that would make Election Day a paid federal holiday as a \"power grab that's smelling more and more li…",
		"url": "http://us.cnn.com/2019/01/31/politics/election-day-holiday-republicans/index.html",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/181221093741-mitch-mcconnell-12032018-super-tease.jpg",
		"publishedAt": "2019-02-01T16:57:16Z",
		"content": "THE POINT -- NOW ON YOUTUBE! \r\nIn each episode of his weekly YouTube show, Chris Cillizza will delve a little deeper into the surreal world of politics. Click to subscribe!"
	}, {
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": "Analysis by Chris Cillizza, CNN Editor-at-large",
		"title": "5 ways to understand Cory Booker's presidential chances",
		"description": "New Jersey Sen. Cory Booker went public Friday with the least well-kept secret in politics: He's running for president in 2020.",
		"url": "http://us.cnn.com/2019/02/01/politics/cory-booker-2020-president/index.html",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/131017085615-07-cory-booker-1017-story-top.jpg",
		"publishedAt": "2019-02-01T15:15:43Z",
		"content": "THE POINT -- NOW ON YOUTUBE! \r\nIn each episode of his weekly YouTube show, Chris Cillizza will delve a little deeper into the surreal world of politics. Click to subscribe!"
	}, {
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": "Karl de Vries, CNN",
		"title": "Here are the Democrats who have said they're running for president",
		"description": "The 2020 Democratic field is taking shape, with candidates revealing their intentions on a seemingly everyday basis.",
		"url": "http://us.cnn.com/2019/01/21/politics/2020-democrats-running-for-president/index.html",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/190107093415-kamala-harris-us-capitol-super-tease.jpg",
		"publishedAt": "2019-02-01T13:10:46Z",
		"content": "Washington (CNN)The 2020 Democratic field is taking shape, with candidates revealing their intentions on a seemingly everyday basis.\r\nHere's a look at the Democrats who have thrown their hats into the ring. We're going to keep updating this list through the c… [+595 chars]"
	}, {
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": "Joshua A. Douglas",
		"title": "What's Mitch McConnell so afraid of?",
		"description": "Election law professor Joshua Douglas writes: Sen. McConnell, you mock the idea of making Election Day a federal holiday,while ignoring the comprehensive nature of a proposed election reform package as a Democratic \"power grab.\" Senator, are you really afraid…",
		"url": "http://us.cnn.com/2019/01/31/opinions/mitch-mcconnell-wrong-about-democrat-voting-bill-douglas/index.html",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/181008183727-mcconnell-begala-super-tease.jpg",
		"publishedAt": "2019-02-01T12:56:13Z",
		"content": "Joshua A. Douglas is a professor at the University of Kentucky College of Law who specializes in election law, voting rights, and constitutional law. He is the author of the forthcoming book, \"Vote for US: How to Take Back Our Elections and Change the Future … [+7234 chars]"
	}
}*/

    public static void main(String[] args) throws MalformedURLException, IOException {
        String sURL = "https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=bd8bf89dada844038a337700e276b203";
        HelperClass methods = null;
        List<HelperClass> newsList = new ArrayList<>();
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();
        JsonArray jsonArray = null;
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject xd = new JsonObject();
        xd.add("articles", root);
        //Create ConnectToSqlDB Object
        ConnectToMongoDB connectToMongoDB = new ConnectToMongoDB();

        jsonArray = new JsonArray();
        jsonArray.add(root.getAsJsonObject().get("articles"));


        for (int i = 0; i < jsonArray.get(0).getAsJsonArray().size(); i++) {
            try {
                JsonObject jsonobject = jsonArray.get(0).getAsJsonArray().get(i).getAsJsonObject();

                String source = jsonobject.get("source").getAsJsonObject().get("id").toString();
                String author = jsonobject.get("author").toString();
                String title = jsonobject.get("title").toString();
                String description = jsonobject.get("description").toString();
                String u = jsonobject.get("url").toString();
                String urlToImage = jsonobject.get("urlToImage").toString();
                String publisherAt = jsonobject.get("publishedAt").toString();
                String content = jsonobject.get("content").toString();

                methods = new HelperClass(source, author, title, description, u, urlToImage, publisherAt, content);

                newsList.add(methods);

            } catch (Exception ex) {
            }
        }

        //Print to the console.
        for (HelperClass entry : newsList) {
            System.out.println( entry.getTitle());
        }

      //  connectToMongoDB.newInsertIntoMongoDB(newsList, "CNNApi");
        // print form data base to console
     //   List<HelperClass> st1List = connectToMongoDB.newReadListFromMongoDB(newsList, "CNNApi");
     //   for (HelperClass entry : st1List) {
            // System.out.println( entry.getTitle());
        }
        // // + " " + entry.getDescription() + " " + entry.getUrl() + " " + entry.getUrlToImage() + " " + entry.getPublisherAt() + " " + entry.getContent());
        // entry.getSource() + " " + entry.getAuthor() + " " +
        // entry.getSource() + " " + entry.getAuthor() + " " +
}


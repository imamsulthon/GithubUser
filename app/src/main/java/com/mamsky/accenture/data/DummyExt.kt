package com.mamsky.accenture.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mamsky.accenture.data.remote.response.UserResponse

object DummyExt {

    fun getDummyResponse(): List<UserResponse> {
        val type = object : TypeToken<List<UserResponse>>(){}.type
        return Gson().fromJson(dummyResponse, type)
    }

    private const val dummyResponse = "[\n" +
            "  {\n" +
            "    \"login\": \"mojombo\",\n" +
            "    \"id\": 1,\n" +
            "    \"node_id\": \"MDQ6VXNlcjE=\",\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/1?v=4\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/mojombo\",\n" +
            "    \"html_url\": \"https://github.com/mojombo\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/mojombo/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/mojombo/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/mojombo/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/mojombo/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/mojombo/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/mojombo/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/mojombo/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/mojombo/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/mojombo/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"login\": \"defunkt\",\n" +
            "    \"id\": 2,\n" +
            "    \"node_id\": \"MDQ6VXNlcjI=\",\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/2?v=4\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/defunkt\",\n" +
            "    \"html_url\": \"https://github.com/defunkt\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/defunkt/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/defunkt/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/defunkt/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/defunkt/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/defunkt/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/defunkt/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/defunkt/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/defunkt/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/defunkt/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"login\": \"railsjitsu\",\n" +
            "    \"id\": 32,\n" +
            "    \"node_id\": \"MDQ6VXNlcjMy\",\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/32?v=4\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/railsjitsu\",\n" +
            "    \"html_url\": \"https://github.com/railsjitsu\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/railsjitsu/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/railsjitsu/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/railsjitsu/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/railsjitsu/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/railsjitsu/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/railsjitsu/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/railsjitsu/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/railsjitsu/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/railsjitsu/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"login\": \"nitay\",\n" +
            "    \"id\": 34,\n" +
            "    \"node_id\": \"MDQ6VXNlcjM0\",\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/34?v=4\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/nitay\",\n" +
            "    \"html_url\": \"https://github.com/nitay\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/nitay/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/nitay/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/nitay/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/nitay/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/nitay/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/nitay/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/nitay/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/nitay/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/nitay/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"login\": \"kevwil\",\n" +
            "    \"id\": 35,\n" +
            "    \"node_id\": \"MDQ6VXNlcjM1\",\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/35?v=4\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/kevwil\",\n" +
            "    \"html_url\": \"https://github.com/kevwil\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/kevwil/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/kevwil/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/kevwil/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/kevwil/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/kevwil/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/kevwil/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/kevwil/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/kevwil/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/kevwil/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"login\": \"KirinDave\",\n" +
            "    \"id\": 36,\n" +
            "    \"node_id\": \"MDQ6VXNlcjM2\",\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/36?v=4\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/KirinDave\",\n" +
            "    \"html_url\": \"https://github.com/KirinDave\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/KirinDave/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/KirinDave/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/KirinDave/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/KirinDave/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/KirinDave/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/KirinDave/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/KirinDave/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/KirinDave/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/KirinDave/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"login\": \"jamesgolick\",\n" +
            "    \"id\": 37,\n" +
            "    \"node_id\": \"MDQ6VXNlcjM3\",\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/37?v=4\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/jamesgolick\",\n" +
            "    \"html_url\": \"https://github.com/jamesgolick\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/jamesgolick/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/jamesgolick/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/jamesgolick/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/jamesgolick/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/jamesgolick/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/jamesgolick/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/jamesgolick/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/jamesgolick/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/jamesgolick/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"login\": \"atmos\",\n" +
            "    \"id\": 38,\n" +
            "    \"node_id\": \"MDQ6VXNlcjM4\",\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/38?v=4\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/atmos\",\n" +
            "    \"html_url\": \"https://github.com/atmos\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/atmos/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/atmos/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/atmos/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/atmos/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/atmos/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/atmos/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/atmos/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/atmos/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/atmos/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"login\": \"errfree\",\n" +
            "    \"id\": 44,\n" +
            "    \"node_id\": \"MDEyOk9yZ2FuaXphdGlvbjQ0\",\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/44?v=4\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/errfree\",\n" +
            "    \"html_url\": \"https://github.com/errfree\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/errfree/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/errfree/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/errfree/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/errfree/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/errfree/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/errfree/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/errfree/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/errfree/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/errfree/received_events\",\n" +
            "    \"type\": \"Organization\",\n" +
            "    \"site_admin\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"login\": \"mojodna\",\n" +
            "    \"id\": 45,\n" +
            "    \"node_id\": \"MDQ6VXNlcjQ1\",\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/45?v=4\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/mojodna\",\n" +
            "    \"html_url\": \"https://github.com/mojodna\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/mojodna/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/mojodna/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/mojodna/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/mojodna/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/mojodna/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/mojodna/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/mojodna/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/mojodna/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/mojodna/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"login\": \"bmizerany\",\n" +
            "    \"id\": 46,\n" +
            "    \"node_id\": \"MDQ6VXNlcjQ2\",\n" +
            "    \"avatar_url\": \"https://avatars.githubusercontent.com/u/46?v=4\",\n" +
            "    \"gravatar_id\": \"\",\n" +
            "    \"url\": \"https://api.github.com/users/bmizerany\",\n" +
            "    \"html_url\": \"https://github.com/bmizerany\",\n" +
            "    \"followers_url\": \"https://api.github.com/users/bmizerany/followers\",\n" +
            "    \"following_url\": \"https://api.github.com/users/bmizerany/following{/other_user}\",\n" +
            "    \"gists_url\": \"https://api.github.com/users/bmizerany/gists{/gist_id}\",\n" +
            "    \"starred_url\": \"https://api.github.com/users/bmizerany/starred{/owner}{/repo}\",\n" +
            "    \"subscriptions_url\": \"https://api.github.com/users/bmizerany/subscriptions\",\n" +
            "    \"organizations_url\": \"https://api.github.com/users/bmizerany/orgs\",\n" +
            "    \"repos_url\": \"https://api.github.com/users/bmizerany/repos\",\n" +
            "    \"events_url\": \"https://api.github.com/users/bmizerany/events{/privacy}\",\n" +
            "    \"received_events_url\": \"https://api.github.com/users/bmizerany/received_events\",\n" +
            "    \"type\": \"User\",\n" +
            "    \"site_admin\": false\n" +
            "  }\n" +
            "]"
}
package plus.maa.backend.repository;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import plus.maa.backend.repository.entity.github.GithubCommit;
import plus.maa.backend.repository.entity.github.GithubTrees;

import java.util.List;

/**
 * @author dragove
 * created on 2022/12/23
 */
public interface GithubRepository {

    /**
     * api doc: <a href="https://docs.github.com/en/rest/git/trees?apiVersion=2022-11-28#get-a-tree">git trees api</a>
     */
    @Headers({
            "Accept: application/vnd.github+json",
            "Authorization: {token}",
            "X-GitHub-Api-Version: 2022-11-28"
    })
    @RequestLine("GET /repos/{repo}/git/trees/{sha}")
    GithubTrees getTrees(@Param("token") String token,
                         @Param("repo") String repo,
                         @Param("sha") String sha);

    @Headers({
            "Accept: application/vnd.github+json",
            "Authorization: {token}",
            "X-GitHub-Api-Version: 2022-11-28"
    })
    @RequestLine("GET /repos/{repo}/commits")
    List<GithubCommit> getCommits(@Param("token") String token,
                                  @Param("repo") String repo,
                                  @Param("path") String path,
                                  @Param("per_page") int prePage);
}

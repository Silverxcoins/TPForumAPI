package dao;

import controllers.CustomResponse;

import java.util.List;

/**
 * Created by parallels on 3/20/16.
 */
public interface ThreadDAO {
    void truncateTable();

    int count();

    CustomResponse create(String threadString);

    CustomResponse details(String threadId, List<String> related);
}
package plus.maa.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import plus.maa.backend.repository.entity.CommentsArea;

import java.util.List;

/**
 * @author LoMu
 * Date  2023-02-17 15:06
 */

@Repository
public interface CommentsAreaRepository extends MongoRepository<CommentsArea, String> {
    List<CommentsArea> findByMainCommentIdAndDeleteIsFalse(String commentsId);

    List<CommentsArea> findByMainCommentId(String commentsId);

    Page<CommentsArea> findByCopilotIdAndDeleteAndMainCommentIdExists(
            Long copilotId,
            boolean delete,
            boolean exists,
            Pageable pageable
    );

}

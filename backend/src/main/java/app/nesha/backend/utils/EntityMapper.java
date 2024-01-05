package app.nesha.backend.utils;

import java.util.List;

public interface EntityMapper<Entity, Req, Response> {
    Response toResponse(Entity entity);
    List<Response> toResponseList(List<Entity> entityList);

    Entity toEntity(Req request);
    List<Entity> toEntityList(List<Req> requestList);
}

alter table user_tags
    add constraint user_tags_pk
        primary key (user_id, tag_id);
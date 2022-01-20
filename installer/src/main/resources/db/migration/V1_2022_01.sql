-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS "public"."test";
CREATE TABLE "public"."test" (
                                     "create_at" timestamp(6),
                                     "update_at" timestamp(6),
                                     "delete_at" timestamp(6),
                                     "create_user_id" int4,
                                     "update_user_id" int4,
                                     "delete_user_id" int4,
                                     "id" int4 NOT NULL,
                                     "name" varchar(255) COLLATE "pg_catalog"."default",
                                     "pid" int4,
                                     "description" varchar(255) COLLATE "pg_catalog"."default"
)
    INHERITS ("public"."base")
;
COMMENT ON COLUMN "public"."category"."description" IS '测试表';
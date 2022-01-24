/*
 Navicat Premium Data Transfer

 Source Server         : localpg
 Source Server Type    : PostgreSQL
 Source Server Version : 130004
 Source Host           : localhost:5432
 Source Catalog        : mall
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 130004
 File Encoding         : 65001

 Date: 24/01/2022 17:00:49
*/


-- ----------------------------
-- Sequence structure for casbin_rule_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."casbin_rule_id_seq";
CREATE SEQUENCE "public"."casbin_rule_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for category_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."category_id_seq";
CREATE SEQUENCE "public"."category_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for customer_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."customer_id_seq";
CREATE SEQUENCE "public"."customer_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for product_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."product_id_seq";
CREATE SEQUENCE "public"."product_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for product_snapshot_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."product_snapshot_id_seq";
CREATE SEQUENCE "public"."product_snapshot_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
CACHE 1;

-- ----------------------------
-- Table structure for base
-- ----------------------------
DROP TABLE IF EXISTS "public"."base";
CREATE TABLE "public"."base" (
  "create_at" timestamp(6),
  "update_at" timestamp(6),
  "delete_at" timestamp(6),
  "create_user_id" int4,
  "update_user_id" int4,
  "delete_user_id" int4
)
;

-- ----------------------------
-- Table structure for casbin_rule
-- ----------------------------
DROP TABLE IF EXISTS "public"."casbin_rule";
CREATE TABLE "public"."casbin_rule" (
  "id" int4 NOT NULL DEFAULT nextval('casbin_rule_id_seq'::regclass),
  "ptype" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "v0" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "v1" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "v2" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "v3" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "v4" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying,
  "v5" varchar(255) COLLATE "pg_catalog"."default" DEFAULT NULL::character varying
)
;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS "public"."category";
CREATE TABLE "public"."category" (
  "create_at" timestamp(6),
  "update_at" timestamp(6),
  "delete_at" timestamp(6),
  "create_user_id" int4,
  "update_user_id" int4,
  "delete_user_id" int4,
  "id" int4 NOT NULL GENERATED ALWAYS AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "pid" int4,
  "description" varchar(255) COLLATE "pg_catalog"."default"
)
INHERITS ("public"."base")
;
COMMENT ON COLUMN "public"."category"."description" IS '描述信息';

-- ----------------------------
-- Table structure for category_product
-- ----------------------------
DROP TABLE IF EXISTS "public"."category_product";
CREATE TABLE "public"."category_product" (
  "id" int4 NOT NULL,
  "category_id" int4,
  "product_id" int4
)
;
COMMENT ON COLUMN "public"."category_product"."category_id" IS '分类id';
COMMENT ON COLUMN "public"."category_product"."product_id" IS '产品id';

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer";
CREATE TABLE "public"."customer" (
  "create_at" timestamp(6),
  "update_at" timestamp(6),
  "delete_at" timestamp(6),
  "create_user_id" int4,
  "update_user_id" int4,
  "delete_user_id" int4,
  "id" int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "username" varchar(255) COLLATE "pg_catalog"."default",
  "password" varchar(255) COLLATE "pg_catalog"."default"
)
INHERITS ("public"."base")
;

-- ----------------------------
-- Table structure for flyway_schema_history
-- ----------------------------
DROP TABLE IF EXISTS "public"."flyway_schema_history";
CREATE TABLE "public"."flyway_schema_history" (
  "installed_rank" int4 NOT NULL,
  "version" varchar(50) COLLATE "pg_catalog"."default",
  "description" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "type" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "script" varchar(1000) COLLATE "pg_catalog"."default" NOT NULL,
  "checksum" int4,
  "installed_by" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "installed_on" timestamp(6) NOT NULL DEFAULT now(),
  "execution_time" int4 NOT NULL,
  "success" bool NOT NULL
)
;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS "public"."order";
CREATE TABLE "public"."order" (
  "create_at" timestamp(6),
  "update_at" timestamp(6),
  "delete_at" timestamp(6),
  "create_user_id" int4,
  "update_user_id" int4,
  "delete_user_id" int4,
  "id" int4 NOT NULL,
  "order_id" varchar COLLATE "pg_catalog"."default",
  "total_price" int8,
  "total_amount" int8,
  "customer_id" int4
)
INHERITS ("public"."base")
;

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS "public"."order_item";
CREATE TABLE "public"."order_item" (
  "create_at" timestamp(6),
  "update_at" timestamp(6),
  "delete_at" timestamp(6),
  "create_user_id" int4,
  "update_user_id" int4,
  "delete_user_id" int4,
  "id" int4 NOT NULL,
  "order_id" varchar COLLATE "pg_catalog"."default",
  "quantity" varchar(255) COLLATE "pg_catalog"."default",
  "total_price" numeric(10,2),
  "snapshot_id" int8
)
INHERITS ("public"."base")
;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS "public"."product";
CREATE TABLE "public"."product" (
  "create_at" timestamp(6),
  "update_at" timestamp(6),
  "delete_at" timestamp(6),
  "create_user_id" int4,
  "update_user_id" int4,
  "delete_user_id" int4,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "sale_price" int4,
  "id" int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
)
)
INHERITS ("public"."base")
;
COMMENT ON COLUMN "public"."product"."sale_price" IS '销售价格';
COMMENT ON COLUMN "public"."product"."id" IS '记录id';

-- ----------------------------
-- Table structure for product_snapshot
-- ----------------------------
DROP TABLE IF EXISTS "public"."product_snapshot";
CREATE TABLE "public"."product_snapshot" (
  "create_at" timestamp(6),
  "update_at" timestamp(6),
  "delete_at" timestamp(6),
  "create_user_id" int4,
  "update_user_id" int4,
  "delete_user_id" int4,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "sale_price" int4,
  "id" int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 2147483647
START 1
),
  "product_id" int4,
  "sale_status" int2
)
INHERITS ("public"."product")
;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "public"."user";
CREATE TABLE "public"."user" (
  "create_at" timestamp(6),
  "update_at" timestamp(6),
  "delete_at" timestamp(6),
  "create_user_id" int4,
  "update_user_id" int4,
  "delete_user_id" int4,
  "id" int4 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "username" varchar(255) COLLATE "pg_catalog"."default",
  "password" varchar(255) COLLATE "pg_catalog"."default"
)
INHERITS ("public"."base")
;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."casbin_rule_id_seq"
OWNED BY "public"."casbin_rule"."id";
SELECT setval('"public"."casbin_rule_id_seq"', 10, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."category_id_seq"
OWNED BY "public"."category"."id";
SELECT setval('"public"."category_id_seq"', 16, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."customer_id_seq"
OWNED BY "public"."customer"."id";
SELECT setval('"public"."customer_id_seq"', 27, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."product_id_seq"
OWNED BY "public"."product"."id";
SELECT setval('"public"."product_id_seq"', 20, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."product_snapshot_id_seq"
OWNED BY "public"."product_snapshot"."id";
SELECT setval('"public"."product_snapshot_id_seq"', 12, true);

-- ----------------------------
-- Primary Key structure for table casbin_rule
-- ----------------------------
ALTER TABLE "public"."casbin_rule" ADD CONSTRAINT "casbin_rule_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table category
-- ----------------------------
ALTER TABLE "public"."category" ADD CONSTRAINT "category_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table category_product
-- ----------------------------
ALTER TABLE "public"."category_product" ADD CONSTRAINT "category_product_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table customer
-- ----------------------------
ALTER TABLE "public"."customer" ADD CONSTRAINT "customer_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table flyway_schema_history
-- ----------------------------
CREATE INDEX "flyway_schema_history_s_idx" ON "public"."flyway_schema_history" USING btree (
  "success" "pg_catalog"."bool_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table flyway_schema_history
-- ----------------------------
ALTER TABLE "public"."flyway_schema_history" ADD CONSTRAINT "flyway_schema_history_pk" PRIMARY KEY ("installed_rank");

-- ----------------------------
-- Primary Key structure for table order
-- ----------------------------
ALTER TABLE "public"."order" ADD CONSTRAINT "order_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table order_item
-- ----------------------------
ALTER TABLE "public"."order_item" ADD CONSTRAINT "order_item_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "public"."user" ADD CONSTRAINT "user_pkey" PRIMARY KEY ("id");

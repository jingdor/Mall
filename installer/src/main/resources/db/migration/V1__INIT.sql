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
  "id" int4 NOT NULL,
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
  "id" int4 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "username" varchar(255) COLLATE "pg_catalog"."default",
  "password" varchar(255) COLLATE "pg_catalog"."default"
)
INHERITS ("public"."base")
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
  "description" varchar(255) COLLATE "pg_catalog"."default"
)
INHERITS ("public"."base")
;

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
  "id" int8 NOT NULL
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
-- Primary Key structure for table order
-- ----------------------------
ALTER TABLE "public"."order" ADD CONSTRAINT "order_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table order_item
-- ----------------------------
ALTER TABLE "public"."order_item" ADD CONSTRAINT "order_item_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table product_snapshot
-- ----------------------------
ALTER TABLE "public"."product_snapshot" ADD CONSTRAINT "product_snapshot_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "public"."user" ADD CONSTRAINT "user_pkey" PRIMARY KEY ("id");

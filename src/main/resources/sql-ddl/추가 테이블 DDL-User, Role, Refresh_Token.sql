--------------------------------------------------------
--  파일이 생성됨 - 일요일-7월-24-2022   
--------------------------------------------------------

--------------------------------------------------------
--  DDL for Table ETAX_USER
--------------------------------------------------------

  CREATE TABLE "KEY_POWEREDI"."ETAX_USER" 
   (	"USER_ID" NUMBER(19,0), 
	"CREATED_DATE" TIMESTAMP (6), 
	"MODIFIED_DATE" TIMESTAMP (6), 
	"EMAIL" VARCHAR2(30 CHAR), 
	"NAME" VARCHAR2(50 CHAR), 
	"NICK_NAME" VARCHAR2(20 CHAR), 
	"PASSWORD" VARCHAR2(100 CHAR), 
	"PROVIDER" VARCHAR2(100 CHAR), 
	"USERNAME" VARCHAR2(20 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Table ETAX_USER_ROLES
--------------------------------------------------------

  CREATE TABLE "KEY_POWEREDI"."ETAX_USER_ROLES" 
   (	"ETAX_USER_USER_ID" NUMBER(19,0), 
	"ROLES" VARCHAR2(255 CHAR)
   )  ;

--------------------------------------------------------
--  DDL for Table REFRESH_TOKEN
--------------------------------------------------------

  CREATE TABLE "KEY_POWEREDI"."REFRESH_TOKEN" 
   (	"ID" NUMBER(10,0), 
	"CREATED_DATE" TIMESTAMP (6), 
	"MODIFIED_DATE" TIMESTAMP (6), 
	"KEY" NUMBER(19,0), 
	"TOKEN" VARCHAR2(255 CHAR)
   ) ;
--------------------------------------------------------
--  DDL for Index EAI_TAX_CONTRACT_IDX
--------------------------------------------------------


  CREATE UNIQUE INDEX "KEY_POWEREDI"."ETAX_USER_IDX1" ON "KEY_POWEREDI"."ETAX_USER" ("USER_ID");
--------------------------------------------------------
--  DDL for Index UK_EL4J3UCEOC8TOLGIMT43L5YP9
--------------------------------------------------------

  CREATE UNIQUE INDEX "KEY_POWEREDI"."UK_EL4J3UCEOC8TOLGIMT43L5YP9" ON "KEY_POWEREDI"."ETAX_USER" ("USERNAME") ;

--------------------------------------------------------
--  DDL for Index SYS_C008658
--------------------------------------------------------

  CREATE UNIQUE INDEX "KEY_POWEREDI"."SYS_C008658" ON "KEY_POWEREDI"."REFRESH_TOKEN" ("ID");
 
--------------------------------------------------------
--  Constraints for Table ETAX_USER
--------------------------------------------------------

  ALTER TABLE "KEY_POWEREDI"."ETAX_USER" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "KEY_POWEREDI"."ETAX_USER" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "KEY_POWEREDI"."ETAX_USER" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "KEY_POWEREDI"."ETAX_USER" MODIFY ("NICK_NAME" NOT NULL ENABLE);
  ALTER TABLE "KEY_POWEREDI"."ETAX_USER" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "KEY_POWEREDI"."ETAX_USER" ADD PRIMARY KEY ("USER_ID");
  ALTER TABLE "KEY_POWEREDI"."ETAX_USER" ADD CONSTRAINT "UK_EL4J3UCEOC8TOLGIMT43L5YP9" UNIQUE ("USERNAME");
  
--------------------------------------------------------
--  Constraints for Table ETAX_USER_ROLES
--------------------------------------------------------

  ALTER TABLE "KEY_POWEREDI"."ETAX_USER_ROLES" MODIFY ("ETAX_USER_USER_ID" NOT NULL ENABLE);
  
--------------------------------------------------------
--  Constraints for Table REFRESH_TOKEN
--------------------------------------------------------

  ALTER TABLE "KEY_POWEREDI"."REFRESH_TOKEN" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "KEY_POWEREDI"."REFRESH_TOKEN" MODIFY ("KEY" NOT NULL ENABLE);
  ALTER TABLE "KEY_POWEREDI"."REFRESH_TOKEN" MODIFY ("TOKEN" NOT NULL ENABLE);
  ALTER TABLE "KEY_POWEREDI"."REFRESH_TOKEN" ADD PRIMARY KEY ("ID");
  
--------------------------------------------------------
--  Ref Constraints for Table ETAX_USER_ROLES
--------------------------------------------------------

  ALTER TABLE "KEY_POWEREDI"."ETAX_USER_ROLES" ADD CONSTRAINT "FKCU4XR4PTIWW6EOWRJU6CRN9IR" FOREIGN KEY ("ETAX_USER_USER_ID")
	  REFERENCES "KEY_POWEREDI"."ETAX_USER" ("USER_ID") ENABLE;

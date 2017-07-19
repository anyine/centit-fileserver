
create table FILE_ACCESS_LOG  (
   access_token       varchar2(36)                    not null,
   FILE_ID              varchar2(36),
   auth_time          date                            not null,
   access_usercode    varchar2(8),
   access_usename     varchar2(50),
   access_right       varchar2(2)                     not null,
   token_expire_time  date                            not null,
   access_times       NUMBER(6)                      default 0 not null,
   last_access_time   date,
   last_access_host   varchar2(100),
   constraint PK_FILE_ACCESS_LOG primary key (access_token)
);
comment on column FILE_ACCESS_LOG.access_right is
'A�� ����Ȩ��  S: ����Դ�ļ�  T �����ظ����ļ� ';

create table FILE_STORE_INFO  (
   FILE_ID              varchar2(36)                    not null,
   FILE_MD5             VARCHAR(36),
   file_name          varchar2(200),
   file_Show_path     varchar2(1000),
   file_Store_path    varchar2(200),
   file_type          varchar2(8),
   file_Desc          varchar2(200),
   file_state         CHAR,
   file_size          NUMBER(20),
   download_times     NUMBER(6),
   OS_ID                varchar2(20),
   Opt_ID             varchar2(64)                    not null,
   OPT_Method         varchar2(64),
   opt_Tag            varchar2(200),
   created            varchar2(8),
   create_time        date,
   index_state        CHAR,
   encrypt_type       CHAR,
   file_owner         VARCHAR(32),
   file_unit          VARCHAR(32),
   attached_Store_path varchar2(200),
   attached_type      varchar2(1),
   constraint PK_FILE_STORE_INFO primary key (FILE_ID)
);

comment on table FILE_STORE_INFO is
'����ֻ�����ļ���Ŀ¼��Ϣ';

comment on column FILE_STORE_INFO.FILE_MD5 is
'�ļ�MD5����';

comment on column FILE_STORE_INFO.file_name is
'ԭʼ�ļ�����';

comment on column FILE_STORE_INFO.file_type is
'�ļ���׺��';

comment on column FILE_STORE_INFO.file_state is
'C : �����ϴ�  N : ���� Z:���ļ� F:�ļ��ϴ�ʧ��';

comment on column FILE_STORE_INFO.Opt_ID is
'ģ�飬���߱�';

comment on column FILE_STORE_INFO.OPT_Method is
'�����������ֶ�';

comment on column FILE_STORE_INFO.opt_Tag is
'һ�����ڹ�����ҵ������';

comment on column FILE_STORE_INFO.index_state is
'N ������Ҫ���� S���ȴ����� I�������� F:����ʧ��';

comment on column FILE_STORE_INFO.encrypt_type is
'N : û�м���   Z��zipFile    D:DES����';

comment on column FILE_STORE_INFO.attached_type is
'�����ļ����N :   û��  T������ͼ  P�� pdfֻ���ļ�';


create index Index_file_md5 on FILE_STORE_INFO (
   FILE_MD5 ASC
);




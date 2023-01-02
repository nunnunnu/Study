create table my_delivery(
md_seq	int	not null	auto_increment	primary key ,
md_mi_seq	int	not null		                    ,
md_address	varchar(255)	not null		        ,
md_detail_address	varchar(255)	not null		,
md_name	varchar(10)	not null		
);

create table lately_delivery(
ld_seq	int	not null	auto_increment	primary key  ,
ld_mi_seq	int	not null		                     ,
ld_address	varchar(255)	not null		         ,
ld_detail_address	varchar(255)	not null		 ,
ld_del_date	date	not null		
);

create table burger_info(
bi_seq	int	not null	auto_increment	primary key  ,
bi_name	varchar(255)	not null		             ,
bi_cate	int	not null		                         ,
bi_detail	text	not null		                 ,
bi_file	text	not null		                     ,
bi_uri	text	not null		
);

create table side_info(
side_seq	int	not null	auto_increment primary key,
side_name	varchar(255)	not null	   ,
side_cate	int	null	                   ,
side_detail	text	not null	           ,
side_file	text	not null	           ,
side_uri	text	not null	
);


create table drink_info(
di_seq	int	not null	auto_increment	primary key   ,
di_name	varchar(255)	not null		              ,
di_cate	int	null	                                  ,
di_detail	text	not null		                  ,
di_file	text	not null		                      ,
di_uri	text	not null		
);

create table dog_info(
dog_seq	int	not null	auto_increment	primary key ,
dog_name	varchar(255)	not null		        ,
dog_cate	int	null		                        ,
dog_detail	text	not null		                ,
di_file	text	not null		                    ,
di_uri	text	not null		                    
);

create table event_info(
ei_seq	int	not null	auto_increment	primary key,
ei_name	varchar(255)	not null		           ,
ei_start_dt	date	not null		               ,
ei_end_dt	date	not null		               ,
ei_price	int	not null		                   ,
ei_detail	text	null		                   ,
ei_di_seq	int	null		                       ,
ei_di2_seq	int	null		                       ,
ei_cate	int	null		                           ,
ei_file	text	not null		                   ,
ei_uri	text	not null		                   
);


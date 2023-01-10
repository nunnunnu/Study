-- create table my_delivery(
-- md_seq	int	not null	auto_increment	primary key ,
-- md_mi_seq	int	not null		                    ,
-- md_address	varchar(255)	not null		        ,
-- md_detail_address	varchar(255)	not null		,
-- md_name	varchar(10)	not null		
-- );
-- 
-- create table lately_delivery(
-- ld_seq	int	not null	auto_increment	primary key  ,
-- ld_mi_seq	int	not null		                     ,
-- ld_address	varchar(255)	not null		         ,
-- ld_detail_address	varchar(255)	not null		 ,
-- ld_del_date	date	not null		
-- );
-- 
-- create table burger_info(
-- bi_seq	int	not null	auto_increment	primary key  ,
-- bi_name	varchar(255)	not null		             ,
-- bi_cate	int	not null		                         ,
-- bi_detail	text	not null		                 ,
-- bi_file	text	not null		                     ,
-- bi_uri	text	not null		
-- );
-- 
-- create table side_info(
-- side_seq	int	not null	auto_increment primary key,
-- side_name	varchar(255)	not null	   ,
-- side_cate	int	null	                   ,
-- side_detail	text	not null	           ,
-- side_file	text	not null	           ,
-- side_uri	text	not null	
-- );
-- 
-- 
-- create table drink_info(
-- di_seq	int	not null	auto_increment	primary key   ,
-- di_name	varchar(255)	not null		              ,
-- di_cate	int	null	                                  ,
-- di_detail	text	not null		                  ,
-- di_file	text	not null		                      ,
-- di_uri	text	not null		
-- );
-- 
-- create table dog_info(
-- dog_seq	int	not null	auto_increment	primary key ,
-- dog_name	varchar(255)	not null		        ,
-- dog_cate	int	null		                        ,
-- dog_detail	text	not null		                ,
-- di_file	text	not null		                    ,
-- di_uri	text	not null		                    
-- );
-- 
-- create table event_info(
-- ei_seq	int	not null	auto_increment	primary key,
-- ei_name	varchar(255)	not null		           ,
-- ei_start_dt	date	not null		               ,
-- ei_end_dt	date	not null		               ,
-- ei_price	int	not null		                   ,
-- ei_detail	text	null		                   ,
-- ei_di_seq	int	null		                       ,
-- ei_di2_seq	int	null		                       ,
-- ei_cate	int	null		                           ,
-- ei_file	text	not null		                   ,
-- ei_uri	text	not null		                   
-- );
-- 
-- INSERT INTO burger_wang.category_info
-- (cate_name)
-- VALUES
-- ('스페셜&할인팩'),
-- ('신제품(NEW)'),
-- ('프리미엄'),
-- ('와퍼&주니어'),
-- ('치킨&슈림프버거'),
-- ('사이드'),
-- ('음료&디저트'),
-- ('독퍼');

select * from category_info ci ;

-- INSERT INTO burger_wang.drink_info
-- (di_name, di_cate, di_detail, di_file, di_uri)
-- VALUES
-- ('아메리카노', 7, 'RA인증커피', 'drink1.jpg', 'drink1'),
-- ('핫초코', 7, null, 'drink2.jpg', 'drink2'),
-- ('아이스초코', 7, null, 'drink3.jpg', 'drink3'),
-- ('코카콜라', 7, '코카콜라로 짜릿하게!', 'drink4.jpg', 'drink4'),
-- ('코카콜라 제로', 7, '100% 짜릿함, 칼로리는 제로', 'drink5.jpg', 'drink5'),
-- ('스프라이트', 7, '나를 깨우는 상쾌함', 'drink6.jpg', 'drink6'),
-- ('씨그램', 7, null, 'drink7.jpg', 'drink7'),
-- ('머닛메이드 오렌지', 7, null, 'drink8.jpg', 'drink8'),
-- ('순수(미네랄워터)', 7, null, 'drink9.jpg', 'drink9');

INSERT INTO burger_wang.drink_option
(do_name, do_price, do_size, do_file, do_uri)
VALUES
('콜라 L', 2800, 2, 'drinkoption1.jpg', 'drinkoption1'),
('코카콜라 제로 L 교환', 2800, 2, 'drinkoption2.jpg', 'drinkoption2'),
('스프라이트 L 교환', 2800, 2, 'drinkoption3.jpg', 'drinkoption3'),
('콜라 R', 2600, 1, 'drinkoption4.jpg', 'drinkoption4'),
('코카콜라 제로 R 교환', 2600, 1, 'drinkoption5.jpg', 'drinkoption5'),
('스프라이트 R 교환', 2600, 1, 'drinkoption6.jpg', 'drinkoption6');

select * from side_info si ;
select * from drink_info di ;
select * from menu_info mi ;
select * from event_info ei ;

select * from member_info mi ;


-- INSERT INTO burger_wang.menu_info
-- (menu_name, menu_price, menu_file, menu_uri, menu_reg_dt, menu_sales_rate, menu_ex, menu_bi_seq, menu_side_seq, menu_di_seq, menu_dog_seq, menu_size, menu_select)
-- VALUES
-- -- ('블랙어니언와퍼 라지세트', 12800, 'menu1.jpg', 'menu', '2022-12-12', 1200, null, 1, 1, 13, null, 2, false);
-- -- ('블랙어니언와퍼세트', 12100, 'menu2.jpg', 'menu2', '2022-12-12', 1300, null, 1, 1, 14, null, 1, false),
-- -- ('기네스콰트로치즈와퍼', 10200, 'menu3.jpg', 'menu3', '2022-11-10', 2400, '단품', 4, null,null, null, null, false),
-- -- ('기네스콰트로치즈와퍼세트', 11500, 'menu4.jpg', 'menu4', '2022-12-08', 100, '기네스콰트로R세트', 4, 1, 14, null, 1, false),
-- -- ('기네스와퍼 라지세트', 12200, 'menu5.jpg', 'menu5', '2022-10-23', 3000, '기네스와퍼+사이드+콜라', 7, 1, 14, null, 2, true),
-- -- ('기네스와퍼 세트', 11500, 'menu6.jpg', 'menu6', '2022-09-12', 5000, null, 7, 2, 14, null, 1, true),
-- -- ('기네스와퍼', 10200, 'menu7.jpg', 'menu7', '2022-05-11', 200, null, 7, null, null, null, null, true),
-- -- ('몬스터와퍼 라지세트', 12200, 'menu8.jpg', 'menu8', '2022-12-10', 2302, '몬스터와퍼+사이드+콜라', 5, 1, 14, null, 2, false),
-- -- ('몬스터와퍼 세트', 11500, 'menu9.jpg', 'menu9', '2022-08-03', 1500, '몬스터와퍼R+사이드+콜라', 5, 2, 14, null, 1, false),
-- -- ('몬스터와퍼', 10200, 'menu10.jpg', 'menu10', '2022-09-03', 1200, null, 1, 1, 14, null, 1, false),
-- -- ('통새우와퍼', 8600, 'menu11.jpg', 'menu11', '2022-10-13', 2000, '단품', 9, null, null, null, null, false);	
-- -- ('앵그리 너겟킹 10조각', 7100, 'menu12.jpg', 'menu12', '2022-05-13', 10000, null, null, 1, null, null, null, false),	
-- -- ('앵그리 너겟킹 6조각', 4700, 'menu13.jpg', 'menu13', '2022-05-13', 10000, null, null, 1, null, null, null, false),	
-- -- ('앵그리 너겟킹 4조각', 3500, 'menu14.jpg', 'menu14', '2022-05-13', 10000, null, null, 1, null, null, null, false),	
-- -- ('너겟킹(10조각)', 7100, 'menu15.jpg', 'menu15', '2022-04-13', 10013, null, null, 2, null, null, null, false),	
-- -- ('너겟킹(6조각)', 4700, 'menu16.jpg', 'menu16', '2022-04-13', 10013, null, null, 2, null, null, null, false),	
-- -- ('너겟킹(4조각)', 3500, 'menu17.jpg', 'menu17', '2022-04-13', 10013, null, null, 2, null, null, null, false),	
-- -- ('21치즈스틱', 2700, 'menu18.jpg', 'menu18', '2022-06-24', 600130, null, null, 3, null, null, null, false),	
-- -- ('어니언링', 3000, 'menu19.jpg', 'menu19', '2022-02-05', 1300, null, null, 4, null, null, null, false),	
-- -- ('바삭킹4조각', 6800, 'menu20.jpg', 'menu20', '2022-08-25', 13021, null, null, 5, null, null, null, false),	
-- -- ('바삭킹2조각', 3800, 'menu21.jpg', 'menu21', '2022-08-25', 12315, null, null, 5, null, null, null, false);
-- ('리얼 독퍼', 2900, 'menu22.jpg', 'menu22', '2022-12-01', 1200, null, null, null, null, 1, null, false);

select * from dog_info di ;

-- alter table menu_info drop menu_reg_dt;
-- alter table ingredients_info drop ii_mi_seq;
-- 
alter table order_detail add od_ldot2_seq int null;
-- alter table ingredients_info add ii_menu_seq int null;

-- update burger_info set bi_sales_rate=bi_seq+100;

select * from member_info mi ;

select * from burger_info bi ;

select * from event_info ei ;

select * from ingredients_info ii ;

INSERT INTO burger_wang.event_stock
(es_si_seq, es_ei_seq, es_stock)
VALUES
(1, 1, 100),
(1, 2, 100),
(1, 3, 100),
(1, 4, 100),
(1, 5, 100),
(1, 6, 100),
(1, 7, 100),
(1, 8, 100),
(1, 9, 100),
(2, 1, 100),
(2, 2, 100),
(2, 3, 100),
(2, 4, 100),
(2, 5, 100),
(2, 6, 100),
(2, 7, 100),
(2, 8, 100),
(2, 9, 100),
(3, 1, 100),
(3, 2, 100),
(3, 3, 100),
(3, 4, 100),
(3, 5, 100),
(3, 6, 100),
(3, 7, 100),
(3, 8, 100),
(3, 9, 100),
(4, 1, 100),
(4, 2, 100),
(4, 3, 100),
(4, 4, 100),
(4, 5, 100),
(4, 6, 100),
(4, 7, 100),
(4, 8, 100),
(4, 9, 100),
(5, 1, 100),
(5, 2, 100),
(5, 3, 100),
(5, 4, 100),
(5, 5, 100),
(5, 6, 100),
(5, 7, 100),
(5, 8, 100),
(5, 9, 100),
(6, 1, 100),
(6, 2, 100),
(6, 3, 100),
(6, 4, 100),
(6, 5, 100),
(6, 6, 100),
(6, 7, 100),
(6, 8, 100),
(6, 9, 100),
(7, 1, 100),
(7, 2, 100),
(7, 3, 100),
(7, 4, 100),
(7, 5, 100),
(7, 6, 100),
(7, 7, 100),
(7, 8, 100),
(7, 9, 100),
(8, 1, 100),
(8, 2, 100),
(8, 3, 100),
(8, 4, 100),
(8, 5, 100),
(8, 6, 100),
(8, 7, 100),
(8, 8, 100),
(8, 9, 100),
(9, 1, 100),
(9, 2, 100),
(9, 3, 100),
(9, 4, 100),
(9, 5, 100),
(9, 6, 100),
(9, 7, 100),
(9, 8, 100),
(9, 9, 100),
(10, 1, 100),
(10, 2, 100),
(10, 3, 100),
(10, 4, 100),
(10, 5, 100),
(10, 6, 100),
(10, 7, 100),
(10, 8, 100),
(10, 9, 100);

select * from event_stock;

select * from my_delivery md ;

-- create database burger_wang;
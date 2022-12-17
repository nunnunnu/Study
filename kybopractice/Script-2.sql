-- create database kyobo_practice;
-- 
-- create table book_writer_info(
-- 	bwi_seq	int	not null	auto_increment	primary key,
-- 	bwi_bi_seq	int	not null		,
-- 	bwi_ai_seq	int	not null		
-- );
-- create table book_translator_info (
-- bti_seq	int	not null	auto_increment	primary key,
-- bti_name	varchar(255)	not null		
-- );
-- 
-- create table member_info (
-- mi_seq	int	not null	auto_increment	primary key,
-- mi_id	varchar(20)	not null		,
-- mi_pwd	varchar(30)	not null		
-- );
-- create table review_info (
-- ri_seq	int	not null	auto_increment	primary key,
-- ri_date	datetime	not null	default now()	,
-- ri_content	text	not null	,	
-- ri_score	int	not null	,	
-- ri_mi_seq	int	not null	,	
-- ri_bi_seq	int	not null		
-- );
-- 
-- create table cover_image(
-- ci_seq	int	not null	auto_increment	primary key,
-- ci_path	text	not null		,
-- ci_bi_seq	int	not null	
-- );
-- 
-- create table book_text_intro (
-- bti_seq	int	not null	auto_increment	primary key,
-- bti_bi_seq	int	not null		,
-- bti_intro	text	not null		
-- );
-- 
-- create table book_intro_image(
-- bii_seq	int	not null	auto_increment	primary key,
-- bii_bi_seq	int	not null	,
-- bii_image	varchar(255)	not null		
-- );
-- 
-- create table author_info(
-- 	ai_seq	int	not null	auto_increment	primary key,
-- ai_name	varchar(255)	not null		
-- );
-- 
-- create table publisher_info(
-- pi_seq	int	not null	auto_increment	primary key,
-- pi_name	varchar(255)	not null		
-- );
-- 
-- create table book_info(
-- bi_seq	int	not null	auto_increment	primary key,
-- bi_title	varchar(255)	not null,		
-- bi_price	int	not null		    ,
-- bi_discount	double	not null		,
-- bi_delivery	varchar(30)	not null	,
-- bi_reg_dt	date	not null		,
-- bi_pi_seq	int	not null		    ,
-- bi_ti_seq	int	not null		    ,
-- bi_sales	int	null	default 0	
-- );\

INSERT INTO kyobo_practice.member_info
(mi_id, mi_pwd)
VALUES
('user001', '1234'),
('user002', '1234'),
('user003', '1234'),
('user004', '1234'),
('user005', '1234'),
('user006', '1234'),
('user007', '1234'),
('user008', '1234'),
('user009', '1234'),
('user010', '1234');


INSERT INTO kyobo_practice.author_info
(ai_name)
VALUES('박진희');

INSERT INTO kyobo_practice.publisher_info
(pi_name)
VALUES('출판사');

INSERT INTO kyobo_practice.book_info
(bi_title, bi_price, bi_discount, bi_delivery, bi_reg_dt, bi_pi_seq, bi_ti_seq, bi_sales)
VALUES('책제목', 15000, 0.1, '10000원이상 무료배송', '2021-05-15', 1, null, 15000);

INSERT INTO kyobo_practice.book_writer_info
(bwi_bi_seq, bwi_ai_seq)
VALUES(1, 1);

INSERT INTO kyobo_practice.book_intro_image
(bii_bi_seq, bii_image)
VALUES(1, 'image.jpg');

INSERT INTO kyobo_practice.book_text_intro
(bti_bi_seq, bti_intro)
VALUES(1, '책소개글입니다.');

INSERT INTO kyobo_practice.cover_image
(ci_path, ci_bi_seq)
VALUES('cover1.jpg', 1);


INSERT INTO kyobo_practice.review_info
( ri_content, ri_score, ri_mi_seq, ri_bi_seq)
VALUES
('리뷰내용입니다2', 3, 1, 1),
('리뷰내용입니다3', 2, 1, 1),
('리뷰내용입니다4', 5, 1, 1),
('리뷰내용입니다5', 4, 1, 1);

select  * from review_info ri ;

INSERT INTO kyobo_practice.author_info
(ai_name)
VALUES('낸시');

INSERT INTO kyobo_practice.book_translator_info
(bti_name)
VALUES('번역가');

INSERT INTO kyobo_practice.publisher_info
(pi_name)
VALUES('민음사');

INSERT INTO kyobo_practice.book_info
(bi_title, bi_price, bi_discount, bi_delivery, bi_reg_dt, bi_pi_seq, bi_ti_seq, bi_sales)
VALUES('안녕하세요', 16000, 0.15, '9000원이상 무료배송', '2019-08-03', 2, 1, 500);

INSERT INTO kyobo_practice.book_writer_info
(bwi_bi_seq, bwi_ai_seq)
VALUES(2, 3);

INSERT INTO kyobo_practice.book_intro_image
(bii_bi_seq, bii_image)
VALUES(2, 'imageintro.jpg');

INSERT INTO kyobo_practice.book_text_intro
(bti_bi_seq, bti_intro)
VALUES(2, '연습용책소개글입니다.');

INSERT INTO kyobo_practice.cover_image
(ci_path, ci_bi_seq)
VALUES('cover2.jpg', 2);

INSERT INTO kyobo_practice.review_info
( ri_content, ri_score, ri_mi_seq, ri_bi_seq)
VALUES
-- ('리뷰내용입니다2', 3, 2, 2),
-- ('리뷰내용입니다3', 5, 4, 2),
-- ('리뷰내용입니다4', 4, 8, 2),
('리뷰내용입니다5', 5, 10, 2);

select * from book_writer_info a join author_info b on a.bwi_ai_seq = b.ai_seq ;

-- 책 상세정보 페이지(책 정보) - 뷰 생성
CREATE or replace VIEW book_detail_view as
select  a.bi_seq ,a.bi_title ,a.bi_price ,concat(a.bi_discount *100,'%') as bi_discount,a.bi_delivery 
	,a.bi_reg_dt ,a.bi_pi_seq ,a.bi_ti_seq ,a.bi_sales 
	, b.bti_intro, c.bii_image, d.bti_name, e.ai_name,f.score, a.bi_price*(1-a.bi_discount) as discount_price,
	a.bi_price*(1-a.bi_discount)*0.05 as point , f.review_count, g.ci_path 
from book_info a 
join book_text_intro b on b.bti_bi_seq = a.bi_seq 
join book_intro_image c on c.bii_bi_seq =a.bi_seq 
left outer join book_translator_info d on a.bi_ti_seq = d.bti_seq 
join (
select h.bwi_bi_seq, group_concat(ai_name) as ai_name  from book_writer_info h join author_info i on h.bwi_ai_seq = i.ai_seq
group by h.bwi_bi_seq
) e on e.bwi_bi_seq = a.bi_seq 
join (
select avg(ri_score) as score, count(*) as review_count, ri_bi_seq  from review_info 
group by ri_bi_seq
) f on f.ri_bi_seq = a.bi_seq
join cover_image g on g.ci_bi_seq = a.bi_seq ;
-- where a.bi_seq = 1;
-- 책 상세정보 페이지(리뷰 전체 출력)
-- create view review_info_view as
select a.*, b.mi_id from review_info a
join member_info b on a.ri_mi_seq =b.mi_seq 
 -- offset은 (1*page)-1 로 연산하면 될거같음!!

create or replace 'auth/er_info_view' as 
select * from book_writer_info a join author_info b on a.bwi_ai_seq = b.ai_seq;


select  * from book_translator_info bti ;
select * from book_info bi ;
select  * from review_info ri ;
select  * from cover_image ci ;

-- 책 리스트
-- create view book_list as
select  a.bi_seq ,a.bi_title ,a.bi_price ,a.bi_discount ,a.bi_reg_dt,
	b.bti_intro, c.bii_image, d.bti_name, e.ai_name,f.score, a.bi_price*(1-a.bi_discount) as discount_price,
	a.bi_price*(1-a.bi_discount)*0.05 as point , f.review_count, g.ci_path , a.bi_sales 
from book_info a 
join book_text_intro b on b.bti_bi_seq = a.bi_seq 
join book_intro_image c on c.bii_bi_seq =a.bi_seq 
left outer join book_translator_info d on a.bi_ti_seq = d.bti_seq 
join (
select * from book_writer_info a join author_info b on a.bwi_ai_seq = b.ai_seq
) e on e.bwi_bi_seq = a.bi_seq 
join (
select avg(ri_score) as score, count(*) as review_count, ri_bi_seq  from review_info 
group by ri_bi_seq
) f on f.ri_bi_seq = a.bi_seq
join cover_image g on g.ci_bi_seq = a.bi_seq
order by a.bi_sales desc;

desc book_detail_view ;


select * from book_writer_info bwi ;
select * from book_detail_view ;

select h.bwi_bi_seq, group_concat(ai_name)  from book_writer_info h join author_info i on h.bwi_ai_seq = i.ai_seq
group by h.bwi_bi_seq;

-- 코드를 입력하세요
SELECT book_id, date_format(published_date, '%Y-%m-%d') from book
where 
1 
and published_date between 20210101 and 20211231
and category = '인문'
order by published_date
-- 코드를 입력하세요
select CATEGORY, sum(s.sales) TOTAL_SALES
from book b 
    left join BOOK_SALES s 
        on b.BOOK_ID = s.BOOK_ID
where year(s.SALES_DATE) = 2022 
and month(s.SALES_DATE) = 1
group by b.CATEGORY
order by b.category;


# SELECT book_id, sum(sales) from BOOK_SALES
# group by BOOK_ID;
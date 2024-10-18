SELECT b.AUTHOR_ID,	a.AUTHOR_NAME,	b.CATEGORY,	sum(b.price * s.SALES)as TOTAL_SALES
from book b
join AUTHOR a on a.AUTHOR_ID = b.AUTHOR_ID
join BOOK_SALES s on s.BOOK_ID = b.BOOK_ID
where year(s.SALES_DATE) = 2022
and month(s.SALES_DATE) = 1
group by b.AUTHOR_ID, b.CATEGORY
order by b.AUTHOR_ID, b.CATEGORY desc
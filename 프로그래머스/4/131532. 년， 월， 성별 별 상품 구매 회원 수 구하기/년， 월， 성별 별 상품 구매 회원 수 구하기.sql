-- 코드를 입력하세요
SELECT year(SALES_DATE) YEAR, month(SALES_DATE) MONTH, u.GENDER, count(DISTINCT s.user_id) USERS 
from ONLINE_SALE s
join USER_INFO u
    on s.USER_ID = u.USER_ID
where u.GENDER is not null
group by year(SALES_DATE), month(SALES_DATE), u.GENDER
order by year(SALES_DATE), month(SALES_DATE), u.GENDER;
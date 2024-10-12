select year(s.SALES_DATE) YEAR, month(s.SALES_DATE) MONTH, u.GENDER, count(distinct s.USER_ID) USERS 
from ONLINE_SALE as s
    join USER_INFO as u
    on s.user_id = u.user_id
where 
    GENDER is not null
group by YEAR, MONTH, GENDER
order by YEAR, MONTH, GENDER
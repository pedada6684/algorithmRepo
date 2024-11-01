SELECT u.USER_ID,	u.NICKNAME,	sum(b.PRICE) as TOTAL_SALES from USED_GOODS_USER as u
join USED_GOODS_BOARD as b on u.USER_ID = b.WRITER_ID
where b.status = 'DONE'
group by u.USER_ID
having TOTAL_SALES >= 700000
order by TOTAL_SALES asc
-- 코드를 입력하세요
SELECT h.HISTORY_ID, 
# (datediff(h.END_DATE, h.START_DATE)+1) * c.DAILY_FEE as OFee,
case
    when (datediff(h.END_DATE, h.START_DATE)+1) < 7 
        then (datediff(h.END_DATE, h.START_DATE)+1) * c.DAILY_FEE
    when 7 <= (datediff(h.END_DATE, h.START_DATE)+1) and (datediff(h.END_DATE, h.START_DATE)+1) < 30
        then round((datediff(h.END_DATE, h.START_DATE)+1) * c.DAILY_FEE * 
            (1 - (
                select DISCOUNT_RATE 
                from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                where CAR_TYPE = c.CAR_TYPE
                and DURATION_TYPE like '7%'
             )*0.01))
     when 30 <= (datediff(h.END_DATE, h.START_DATE)+1) and (datediff(h.END_DATE, h.START_DATE)+1) < 90
        then round((datediff(h.END_DATE, h.START_DATE)+1) * c.DAILY_FEE * 
            (1 - (
                select DISCOUNT_RATE 
                from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                where CAR_TYPE = c.CAR_TYPE
                and DURATION_TYPE like '30%'
             )*0.01))
    when 90 <= (datediff(h.END_DATE, h.START_DATE)+1)
        then round((datediff(h.END_DATE, h.START_DATE)+1) * c.DAILY_FEE * 
            (1 - (
                select DISCOUNT_RATE 
                from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
                where CAR_TYPE = c.CAR_TYPE
                and DURATION_TYPE like '90%'
             )*0.01))
end as fee
from CAR_RENTAL_COMPANY_CAR c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    on c.CAR_ID = h.CAR_ID
where CAR_TYPE = '트럭'
order by FEE desc, HISTORY_ID desc
# # select * from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
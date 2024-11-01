SELECT
c.CAR_ID, 
c.CAR_TYPE, 
round(c.DAILY_FEE*30*(100-d.DISCOUNT_RATE)/100)as FEE

from CAR_RENTAL_COMPANY_CAR as c
join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h on c.CAR_ID = h.CAR_ID
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as d on d.CAR_TYPE = c.CAR_TYPE and d.DURATION_TYPE = '30일 이상'

where c.CAR_ID not in (
        select distinct CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-12-01'

    )
group by c.CAR_ID
having 
    FEE between 500000 and 2000000
    and c.CAR_TYPE in ('세단','SUV')
order by FEE desc, c.CAR_TYPE asc, c.CAR_ID desc


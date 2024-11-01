SELECT distinct CAR_ID, 
case
    when CAR_ID in (
        select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where 20221016 between START_DATE and END_DATE
    ) then '대여중'
    else '대여 가능'
end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
order by CAR_ID desc

# select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where 20221016 between START_DATE and END_DATE+1
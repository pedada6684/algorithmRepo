select month(START_DATE) MONTH, CAR_ID, count(*) RECORDS from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where 
CAR_ID in
(
    select CAR_ID from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where month(START_DATE) between 8 and 10
    and year(START_DATE) = 2022
    group by CAR_ID
    having count(*) >= 5
)
and month(START_DATE) between 8 and 10
and year(START_DATE) = 2022
group by CAR_ID, MONTH
order by MONTH, CAR_ID desc
WITH RentalDurations AS (
    SELECT 
        h.HISTORY_ID, 
        h.CAR_ID,
        DATEDIFF(h.END_DATE, h.START_DATE) AS Rental_Duration
    FROM 
        CAR_RENTAL_COMPANY_RENTAL_HISTORY h
)

SELECT 
    rd.HISTORY_ID, 
    ROUND((rd.Rental_Duration + 1) * c.DAILY_FEE * 
        CASE 
            WHEN rd.Rental_Duration + 1 < 7 THEN 1
            WHEN rd.Rental_Duration + 1 < 30 THEN 
                (1 - (SELECT DISCOUNT_RATE / 100 
                      FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                      WHERE CAR_TYPE = c.CAR_TYPE 
                      AND DURATION_TYPE LIKE '7%'))
            WHEN rd.Rental_Duration + 1 < 90 THEN 
                (1 - (SELECT DISCOUNT_RATE / 100 
                      FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                      WHERE CAR_TYPE = c.CAR_TYPE 
                      AND DURATION_TYPE LIKE '30%'))
            ELSE 
                (1 - (SELECT DISCOUNT_RATE / 100 
                      FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
                      WHERE CAR_TYPE = c.CAR_TYPE 
                      AND DURATION_TYPE LIKE '90%'))
        END
    ) AS fee
FROM 
    RentalDurations rd
JOIN 
    CAR_RENTAL_COMPANY_CAR c ON c.CAR_ID = rd.CAR_ID
WHERE 
    c.CAR_TYPE = '트럭'
ORDER BY 
    fee DESC, 
    rd.HISTORY_ID DESC;
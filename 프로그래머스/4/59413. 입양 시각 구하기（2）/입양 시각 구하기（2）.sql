SET @hour := -1;

SELECT 
    (@hour := @hour+1) AS HOUR,
    (
        select count(*) from ANIMAL_OUTS where hour(DATETIME) = @hour
    ) as COUNT
FROM 
    ANIMAL_OUTS 
Where
    @hour < 23;
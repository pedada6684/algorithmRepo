
SELECT fp.CATEGORY,	gg.mp as MAX_PRICE, fp.PRODUCT_NAME from FOOD_PRODUCT as fp
join (
        select max(price) as mp, CATEGORY from FOOD_PRODUCT
        group by CATEGORY
    ) as gg on gg.mp = fp.price and gg.CATEGORY = fp.CATEGORY
where fp.CATEGORY in ('과자', '국', '김치', '식용유')
order by MAX_PRICE desc


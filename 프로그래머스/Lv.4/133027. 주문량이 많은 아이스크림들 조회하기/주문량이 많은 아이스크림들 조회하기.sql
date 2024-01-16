# select flavor, total_order from first_half
# order by total_order
# limit 3

# select flavor, sum(total_order) from july
# group by flavor

select first_half.flavor from first_half
right join (
    select flavor, sum(total_order) as sum_total from july
    group by flavor
) as total_july
on first_half.flavor = total_july.flavor
order by first_half.total_order+sum_total desc
limit 3
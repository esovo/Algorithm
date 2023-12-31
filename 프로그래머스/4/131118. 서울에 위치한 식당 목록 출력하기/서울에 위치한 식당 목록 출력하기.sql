-- 코드를 입력하세요
SELECT r.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS, ROUND(AVG(r.REVIEW_SCORE), 2) SCORE
FROM REST_REVIEW r
JOIN REST_INFO i ON r.REST_ID = i.REST_ID
WHERE SUBSTRING(i.ADDRESS, 1, 2) = "서울"
GROUP BY r.REST_ID
ORDER BY SCORE desc;
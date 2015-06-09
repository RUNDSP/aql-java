SELECT COUNT(*) AS clicks FROM events
 GROUP BY userId
 WHERE type = ‘CLICK’

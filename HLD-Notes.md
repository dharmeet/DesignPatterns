# HLD Notes

## Topic wise

| Topic | Description | Use-case |
| ----- | ---------- | --------- |
| Consistent Hashing | multiple hash functions for servers and single hash function for user_id | Used in case of sharding is done by user_id |
|  Load Balancer | Listener (entry point) - Routing (decision making process based on rules and algorithms) - Target Group (collection of servers that actually process the request), Reverse Proxy, Security, Performance, Resilience  | |
| In-Browser Caching | DNS and static information like image, videos and JS files | Mostly used in all the websites |
| CDN (Content Delivery Network) | Store the data, distribute it to all the regions and provide different CDN links to access data in a particular region | Video Streaming like Hoststar, Youtube etc. |
| Local Caching | Caching done on the app server | Tests input and output files for a problem on Scaler, Hackerrank etc. Metadata DB stores the last updated time and compares if we need to get the file from file storage or local cache. | 
| Global Caching | System like Redis, Memcache | Contest ranklist |
| Cache with TTL | Entries in the cache will be valid for only a period, after that if you need it you fetch it again. | Weather Data, Caching currency exchange rates |
| Write through cache | Writing in cache and DB, returning success if both are successful. Writes are slower but reads are much faster. | Read-heavy system, E-commerce inventory update |
| Write back cache | First write in cache, then asynchronously sync with DB. Very high throughput and very low latency. | Social media feeds/counters (eg. likes, count), Video streaming watch history |
| Write around cache | Writes are done directly in the DB, can use TTL to keep cache in sync with the DB | Logging system, Infrequently accessed archival data |


## Case Studies

| S. No. | Problem | Approach |
| ----- | ---------- | --------- |
| 1 | Submit problem on Hackerrank, scaler (etc.) the input and output file is stored in File Storage which can take 2 seconds to fetch | Reading the file from Hard Disk takes 40 ms and reading a record from DB takes 50 ms. Store the file metadata in DB, with problem_id, input_filepath, input_file_updated_at, input_file_created_at and keep the filename as (problem_id)_(updated_at)_input.txt, now when the submission comes check the updated_at in the DB, if the file is present in local cache we are good, else fetch it from the filesystem. |
   
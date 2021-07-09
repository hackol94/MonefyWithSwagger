FROM loadimpact/k6
COPY K6/GetLoadTest.js /usr/test/
COPY K6/GetStressTest.js /usr/test/
COPY K6/PostLoadTest.js /usr/test/
COPY K6/PostStressTest.js /usr/test/

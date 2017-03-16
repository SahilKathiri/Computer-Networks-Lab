
Physical address 	: 98-90-96-ad-7d-b0
IP Address (IPv4)	: 172.16.27.37
Default Gateway 	: 172.16.27.1
Subnet Mask			: 255.255.255.0

URL: http://gaia.cs.umass.edu/wireshark-labs/HTTP-ethereal-lab-file3.html

For Request:
	Ethernet Frame:
		Src MAC: 98-90-96-ad-7d-b0
		Dst MAC: 00-00-0c-07-ac-1b

		Type: IPv4 (0x0800)

	IPv4 Frame:
		Src IP: 172.16.27.37
		Dst IP: 128.119.245.12

	TCP Frame:
		Src Port: 51097 (port used by chrome/other browser to send request)
		Dst Port: 80 	(all web-server apps by default uses this port to serve requests)

	GET request starts from Bytes: 36-end

	Full Text of Request:

		GET /wireshark-labs/HTTP-ethereal-lab-file3.html HTTP/1.1
		Host: gaia.cs.umass.edu
		Connection: keep-alive
		Upgrade-Insecure-Requests: 1
		User-Agent: Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36
		Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
		Accept-Encoding: gzip, deflate, sdch
		Accept-Language: en-US,en;q=0.8


	Last 4 bytes contain CRC (Cyclic Redundancy Check): 0d 0a 0d 0a

For Response:
	Ethernet Frame:
		Src MAC: 88-f0-31-87-97-31
		Dst MAC: 98-90-96-ad-7d-b0

		Type: IPv4 (0x0800)

	IPv4 Frame:
		Src IP: 128.119.245.12
		Dst IP: 172.16.27.37

	TCP Frame:
		Src Port: 80
		Dst Port: 51097

	Full Text of Response:

		HTTP/1.1 200 OK
		Date: Thu, 16 Mar 2017 07:43:14 GMT
		Server: Apache/2.4.6 (CentOS) OpenSSL/1.0.1e-fips PHP/5.4.16 mod_perl/2.0.10 Perl/v5.16.3
		Last-Modified: Thu, 16 Mar 2017 05:59:01 GMT
		ETag: "1194-54ad2c1f9fb2b"
		Accept-Ranges:  none
		Content-Length: 4500
		Keep-Alive: timeout=5, max=100
		Connection: Keep-Alive
		Content-Type: text/html; charset=UTF-8

		<html>
			...
		</html>

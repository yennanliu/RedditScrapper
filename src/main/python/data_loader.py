import requests, json

def get_data(url):
    r = requests.get(url)
    json_data = r.json()
    return json_data['data']


url = "https://api.pushshift.io/reddit/search/comment/?subreddit=TIdaL"
data1 = get_data(url)

with open("output.json", 'a') as f:
    for record in data1:
        print (record)
        f.write(json.dumps(record))


# r = requests.get(url)
# json_data = r.json()
# records = json_data['data']


# url2 = "https://api.pushshift.io/reddit/search/submission/?q=TIdaL"
# r2= requests.get(url2)
# json_data2 = r2.json()
# records2 = json_data2['data']

import requests, json

def get_data(url):
    r = requests.get(url)
    json_data = r.json()
    return json_data['data']

def save_data(json_data, file_name):
 with open(file_name, 'a') as f:
    for i in range(len(json_data)):
        try:
            print (json_data[i])
            f.write(json.dumps(json_data[i]) + "\n")
        except Exception as e:
            print ("save file failed")  

if __name__ == '__main__':
    print ("collect comment data ...")
    url = "https://api.pushshift.io/reddit/search/comment/?subreddit=TIdaL"
    data_comment = get_data(url)
    #save_data(data_comment, "../../../data/raw/comment.json")
    save_data(data_comment, "data/raw/comment.json")

    print ("collect submission data ...")
    url = "https://api.pushshift.io/reddit/search/submission/?q=TIdaL"
    data_comment = get_data(url)
    #save_data(data_comment, "../../../data/raw/comment.json")
    save_data(data_comment, "data/raw/submission.json")

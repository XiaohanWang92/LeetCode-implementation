int removeDuplicates(int* nums, int numsSize) {
    if(numsSize<2)
        return numsSize;
    if(numsSize==2)
        return nums[0]==nums[1]?1:2;//[a,a] must be considered
    int index=1;
    for(int i=1;i<numsSize;i++){
        if(*(nums+i)!=*(nums+i-1)){
            nums[index]=*(nums+i);
            index +=1;
        }
    }
    return index;
}